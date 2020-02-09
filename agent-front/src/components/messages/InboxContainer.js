import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchInbox, resetMessages } from '../../redux'
import InboxUserContainer from './InboxUserContainer'
import { INBOX } from '../../redux/router/routerPaths'
import ChatContainer from './ChatContainer'
import MessageForm from './MessageForm'

function InboxContainer({
    messagesState,
    page,
    loginState,
    fetchInbox,
    resetMessages
}) {
    useEffect(() => {
        if(page === INBOX) {
            fetchInbox(loginState.user.id)
        } else {
            resetMessages()
        }
    }, [page, loginState, fetchInbox, resetMessages])

    return page !== INBOX ? (
        ''
    ) : messagesState.loading ? (
        <h2>Loading...</h2>
    ) : messagesState.error ? (
    <h2>{ messagesState.error }</h2>
    ) : (
        <table>
            <tbody>
                <tr>
                    <td colSpan='1'>
                    {
                        messagesState &&
                        messagesState.inbox &&
                        messagesState.inbox.map((user) => <InboxUserContainer user={ user } />)
                    }
                    </td>
                    <td colSpan='5'>
                        <ChatContainer />   
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td colSpan='5'>
                        <MessageForm />
                    </td>
                </tr>
            </tbody>
        </table>
    )
}

const mapStateToProps = (state) => {
    return {
        messagesState: state.messagesState,
        loginState: state.loginState,
        page: state.route.page
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchInbox: (user) => dispatch(fetchInbox(user)),
        resetMessages: () => dispatch(resetMessages())
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(InboxContainer)
