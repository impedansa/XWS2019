import React from 'react'
import { connect } from 'react-redux'
import { fetchChat } from '../../redux'

function InboxUserContainer({
    user,
    loginState,
    fetchChat
}) {
    const handleClick = (event) => {
        event.preventDefault()
        fetchChat(loginState.user.id, user.id)
    }

    return (
        <div onClick={ (e) => handleClick(e) } className='clickable element'>
           <table>
               <tbody>
                    <tr><td>{ user.name }</td><td>({ user.email })</td></tr>
                    <tr><td colSpan='2'>{ user.phoneNumber }</td></tr>
               </tbody>
            </table> 
        </div>
    )
}

const mapStateToProps = (state) => {
    return {
        loginState: state.loginState
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchChat: (selfId, otherId) => dispatch(fetchChat(selfId, otherId))
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(InboxUserContainer)
