import React from 'react'
import { connect } from 'react-redux'
import { changeUserState } from '../../redux'

function UserContainer({
    user,
    changeUserState
}) {
    const handleClick = (state) => {
        changeUserState(user.id, state)
    }

    return (
        <div>
            <table>
                <tbody>
                    <tr><td>Name:</td><td>{ user.name }</td></tr>
                    <tr><td>Email:</td><td>{ user.email }</td></tr>
                    <tr><td>State:</td><td>{ user.state }</td></tr>
                    <tr><td></td><td><input type='button' value='Activate' onClick={ () => handleClick('ACTIVE') }/></td></tr>
                    <tr><td></td><td><input type='button' value='Block' onClick={ () => handleClick('BLOCKED') }/></td></tr>
                    <tr><td></td><td><input type='button' value='Remove' onClick={ () => handleClick('REMOVED') }/></td></tr>
                </tbody>
            </table>
        </div>
    )
}

const mapDispatchToProps = (dispatch) => {
    return {
        changeUserState: (user, state) => dispatch(changeUserState(user, state))
    }
}

export default connect(
    null,
    mapDispatchToProps
)(UserContainer)
