import axios from 'axios'
import {
    FETCH_INBOX_REQUEST,
    FETCH_INBOX_SUCCESS,
    FETCH_INBOX_ERROR,
    FETCH_CHAT_REQUEST,
    FETCH_CHAT_SUCCESS,
    FETCH_CHAT_ERROR,
    SEND_MESSAGE_REQUEST,
    SEND_MESSAGE_SUCCESS,
    SEND_MESSAGE_ERROR,
    RESET_MESSAGES
} from './messagesTypes'

export const fetchInbox = (selfId) => {
    return (dispatch) => {
        dispatch(fetchInboxRequest())
        axios.get('http://localhost:8762/messages-service/users/' + selfId + '/messages')
            .then((response) => {
                dispatch(fetchInboxSuccess(response.data))
            })
            .catch((error) => {
                dispatch(fetchInboxError(error.message))
            })
    }
}

export const fetchInboxRequest = () => {
    return {
        type: FETCH_INBOX_REQUEST
    }
}

export const fetchInboxSuccess = (inbox) => {
    return {
        type: FETCH_INBOX_SUCCESS,
        payload: inbox
    }
}

export const fetchInboxError = (error) => {
    return {
        type: FETCH_INBOX_ERROR,
        payload: error
    }
}

export const fetchChat = (selfId, otherId) => {
    return (dispatch) => {
        dispatch(fetchChatRequest())
        axios.get('http://localhost:8762/messages-service/users/' + selfId + '/messages/with/' + otherId)
        .then((response) => {
            dispatch(fetchChatSuccess(response.data))
        })
        .catch((error) => {
            dispatch(fetchChatError(error.message))
        })
    }
}

export const fetchChatRequest = () => {
    return  {
        type: FETCH_CHAT_REQUEST
    }
}

export const fetchChatSuccess = (chat) => {
    return {
        type: FETCH_CHAT_SUCCESS,
        payload: chat
    }
}

export const fetchChatError = (error) => {
    return {
        type: FETCH_CHAT_ERROR,
        payload: error
    }
}

export const sendMessage = (selfId, message) => {
    return (dispatch) => {
        dispatch(sendMessageRequest())
        axios.post('http://localhost:8762/messages-service/users/' + selfId + '/messages', message)
            .then((response) => {
                dispatch(sendMessageSuccess(response.data))
            })
            .catch((error) => {
                dispatch(sendMessageError(error.message))
            })
    }
}

export const sendMessageRequest = () => {
    return {
        type: SEND_MESSAGE_REQUEST
    }
}

export const sendMessageSuccess = (message) => {
    return {
        type: SEND_MESSAGE_SUCCESS,
        payload: message
    }
}

export const sendMessageError = (error) => {
    return {
        type: SEND_MESSAGE_ERROR,
        payload: error
    }
}

export const resetMessages = () => {
    return {
        type: RESET_MESSAGES
    }
}