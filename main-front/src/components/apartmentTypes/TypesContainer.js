import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchTypes } from '../../redux'
import { TYPES } from '../../redux/router/routerPaths'
import TypeContainer from './TypeContainer'
import TypeForm from './TypeForm'

function CategoriesContainer({
    page,
    typesState,
    fetchTypes
}) {
    useEffect(() => {
        if(page === TYPES)
            fetchTypes()
    }, [fetchTypes, page])

    return page !== TYPES ? (
        ''
    ) : typesState.loading ? (
        <h2>Loading...</h2>
    ) : typesState.error ? (
        <h2>{ typesState.error }</h2>
    ) : (
        <div>
            <aside>
                <TypeForm />
            </aside>
            <div>
                {
                typesState &&
                typesState.types &&
                typesState.types.map((type) => <TypeContainer type={ type } />)
                }
            </div>
        </div>
    )
}

const mapStateToProps = (state) => {
    return {
        page: state.route.page,
        typesState: state.typesState
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchTypes: () => dispatch(fetchTypes())
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(CategoriesContainer)
