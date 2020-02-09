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

const initialState = {
    loading: false,
    inbox: [],
    chat: [],
    error: ''
}

const messageReducer = (state = initialState, action) => {
    switch(action.type) {
        case FETCH_INBOX_REQUEST:
            return {
                ...state,
                loading: true
            }
        case FETCH_INBOX_SUCCESS:
            return {
                ...state,
                loading: false,
                error: '',
                inbox: action.payload
            }
        case FETCH_INBOX_ERROR:
            return {
                ...initialState,
                error: action.payload
            }
        case FETCH_CHAT_REQUEST:
            return {
                ...state,
                loading: true,
                chat: []
            }
        case FETCH_CHAT_SUCCESS:
            return {
                ...state,
                loading: false,
                chat: action.payload
            }
        case FETCH_CHAT_ERROR:
            return {
                ...state,
                chat: [],
                loading: false,
                error: action.payload
            }
        case SEND_MESSAGE_REQUEST:
            return {
                ...state,
                loading: true
            }
        case SEND_MESSAGE_SUCCESS:
            return {
                ...state,
                loading: false,
                error: ''
            }
        case SEND_MESSAGE_ERROR:
            return {
                ...state,
                loading: false,
                error: action.payload
            }
        case RESET_MESSAGES: return initialState
        default: return state
    }
}

export default messageReducer