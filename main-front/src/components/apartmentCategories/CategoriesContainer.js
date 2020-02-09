import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchCategories } from '../../redux'
import { CATEGORIES } from '../../redux/router/routerPaths'
import CategoryContainer from './CategoryContainer'
import CategoryForm from './CategoryForm'

function CategoriesContainer({
    page,
    categoriesState,
    fetchCategories
}) {
    useEffect(() => {
        if(page === CATEGORIES)
            fetchCategories()
    }, [fetchCategories, page])

    return page !== CATEGORIES ? (
        ''
    ) : categoriesState.loading ? (
        <h2>Loading...</h2>
    ) : categoriesState.error ? (
        <h2>{ categoriesState.error }</h2>
    ) : (
        <div>
            <aside>
                <CategoryForm />
            </aside>
            <div>
                {
                categoriesState &&
                categoriesState.categories &&
                categoriesState.categories.map((category) => <CategoryContainer category={ category } />)
                }
            </div>
        </div>
    )
}

const mapStateToProps = (state) => {
    return {
        page: state.route.page,
        categoriesState: state.categoriesState
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchCategories: () => dispatch(fetchCategories())
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(CategoriesContainer)
