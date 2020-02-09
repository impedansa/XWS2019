import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchCategories } from '../../redux'

function CategorySelect({
    categoriesState,
    fetchCategories,
    handleSelect
}) {

    useEffect(() => {
        fetchCategories()
    }, [fetchCategories])

    return (
        <select style={ { fontSize: 'x-large', fontFamily: '\'Times New Roman\', Times, serif' } } onChange={ (e) => handleSelect(parseInt(e.target.value)) }>
            {
                categoriesState &&
                categoriesState.categories &&
                categoriesState.categories.map((category) => <option value={ category.id } >{ category.name }</option>)
            }
        </select>
    )
}

const mapStateToProps = (state) => {
    return {
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
)(CategorySelect)
