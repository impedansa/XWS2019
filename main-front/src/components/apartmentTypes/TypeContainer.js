import React from 'react'
import { connect } from 'react-redux'
import { deleteType } from '../../redux'

function TypeContainer({
    type,
    deleteType
}) {
    const handleRemove = (event) => {
        event.preventDefault()
        deleteType(type.id)
    }

    return (
        <div className='element'>
            <table><tbody>
                <tr><td>Name:</td><td>{ type.name }</td></tr>
                <tr><td>Description:</td><td>{ type.description }</td></tr>
                <tr><td></td><td><input type='button' value='Remove' onClick={ (e) => handleRemove(e) } /></td></tr>
            </tbody></table>
        </div>
    )
}

const mapDispatchToProps = (dispatch) => {
    return {
        deleteType: (type) => dispatch(deleteType(type))
    }
}

export default connect(
    null,
    mapDispatchToProps
)(TypeContainer)
