import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import MessageContainer from './MessageContainer'

function ChatContainer({
    messages,
    loginState
}) {
    useEffect(() => {}, [messages])

    return (
        <div>
            {
                messages ?
                messages.map((message) => <MessageContainer message={ message } senderId={ loginState.user.id } />) :
                'No messages to show'
            }
        </div>
    )
}

const mapStateToProps = (state) => {
    return {
        messages: state.messagesState.chat,
        loginState: state.loginState
    }
}

export default connect(
    mapStateToProps,
    null
)(ChatContainer)
