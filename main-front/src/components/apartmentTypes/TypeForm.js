import React, { useState } from 'react'
import { connect } from 'react-redux'
import { addType } from '../../redux'

function TypeForm({
    addType
}) {
    const [name, setName] = useState('')
    const [description, setDescription] = useState('')

    const handleCreate = (event) => {
        event.preventDefault()
        addType({
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
        addType: (type) => dispatch(addType(type))
    }
}

export default connect(
    null,
    mapDispatchToProps
)(TypeForm)
