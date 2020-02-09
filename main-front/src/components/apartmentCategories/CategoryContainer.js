import React from 'react'
import { connect } from 'react-redux'
import { deleteCategory } from '../../redux'

function CategoryContainer({
    category,
    deleteCategory
}) {
    const handleRemove = (event) => {
        event.preventDefault()
        deleteCategory(category.id)
    }

    return (
        <div className='element'>
            <table><tbody>
                <tr><td>Name:</td><td>{ category.name }</td></tr>
                <tr><td>Description:</td><td>{ category.description }</td></tr>
                <tr><td></td><td><input type='button' value='Remove' onClick={ (e) => handleRemove(e) } /></td></tr>
            </tbody></table>
        </div>
    )
}

const mapDispatchToProps = (dispatch) => {
    return {
        deleteCategory: (category) => dispatch(deleteCategory(category))
    }
}

export default connect(
    null,
    mapDispatchToProps
)(CategoryContainer)
