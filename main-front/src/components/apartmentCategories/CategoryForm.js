import React, { useState } from 'react'
import { connect } from 'react-redux'
import { addCategory } from '../../redux'

function CategoryForm({
    addCategory
}) {
    const [name, setName] = useState('')
    const [description, setDescription] = useState('')

    const handleCreate = (event) => {
        event.preventDefault()
        addCategory({
            name,
            description
        })
    }

    return (
        <form>
            <div>
                <table><tbody>
                    <tr><td>Name:</td><td><input type='text' value={ name } onChange={ (e) => setName(e.target.value) } /></td></tr>
                    <tr><td>Descirption:</td><td><input type='text' value={ description } onChange={ (e) => setDescription(e.target.value) } /></td></tr>
                    <tr><td></td><td><input type='button' value='Create' onClick={ (e) => handleCreate(e) } /></td></tr>
                </tbody></table>
            </div>
        </form>
    )
}

const mapDispatchToProps = (dispatch) => {
    return {
        addCategory: (category) => dispatch(addCategory(category))
    }
}

export default connect(
    null,
    mapDispatchToProps
)(CategoryForm)
