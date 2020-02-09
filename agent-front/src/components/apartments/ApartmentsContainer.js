import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchApartments } from '../../redux'
import ApartmentContainer from './ApartmentContainer'
import { APARTMENTS } from '../../redux/router/routerPaths'
import ApartmentForm from './ApartmentForm'

function ApartmentContainers({
    apartmentsState,
    page,
    fetchApartments
}) {
    useEffect(() => {
        fetchApartments()
    }, [fetchApartments])

    return page !== APARTMENTS ? (
        ''
    ) : apartmentsState.loading ? (
        <h2>Loading...</h2>
    ) : apartmentsState.error ? (
        <h2>{ apartmentsState.error }</h2>
    ) : (
        <div>
            <aside>
                <ApartmentForm />
            </aside>
            <div>
                { apartmentsState &&
                    apartmentsState.apartments && 
                apartmentsState.apartments.map((apartment) => <ApartmentContainer { ...apartment }/>) }
            </div>
        </div>
    )
}

const mapStateToProps = (state) => {
    return {
        apartmentsState: state.apartmentsState,
        page: state.route.page
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchApartments: () => dispatch(fetchApartments())
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(ApartmentContainers)
