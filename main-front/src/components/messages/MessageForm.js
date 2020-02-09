import React, { useState } from 'react'
import { connect } from 'react-redux'
import { sendMessage, fetchInbox } from '../../redux'

function MessageForm({
    messagesState,
    loginState,
    sendMessage
}) {
    const [message, setMessage] = useState('')

    const determineRecipient = (user, message) => {
        return message.senderId !== user ? message.senderId : message.recipientId
    }

    const handleClick = (event) => {
        event.preventDefault()
        sendMessage(
            loginState.user.id,
            {
                text: message,
                senderId: loginState.user.id,
                recipientId: determineRecipient(loginState.user.id, messagesState.chat[0])
            }
        )
        fetchInbox(loginState.user.id)
    }

    return messagesState.chat && messagesState.chat.length > 0 ? (
        <div>
            <input type='text' value={ message } onChange={ (e) => setMessage(e.target.value) } />
            <input type='button' value='Send' onClick={ (e) => handleClick(e) } />
        </div>
    ) : (
        ''
    )
}

const mapStateToProps = (state) => {
    return {
        messagesState: state.messagesState,
        loginState: state.loginState
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        sendMessage: (selfId, message) => dispatch(sendMessage(selfId, message)),
        fetchInbox: (selfId) => dispatch(fetchInbox(selfId))
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(MessageForm)
