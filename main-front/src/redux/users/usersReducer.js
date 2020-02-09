import {
    FETCH_USERS_REQUEST,
    FETCH_USERS_SUCCESS,
    FETCH_USERS_ERROR,
    ADD_AGENT_REQUEST,
    ADD_AGENT_SUCCESS,
    ADD_AGENT_ERROR,
    CHANGE_USER_STATE_REQUEST,
    CHANGE_USER_STATE_SUCCESS,
    CHANGE_USER_STATE_ERROR
} from './usersTypes'

const initialState = {
    loading: true,
    users: [],
    error: ''
}

const usersReducer = (state = initialState, action) => {
    switch(action.type) {
        case FETCH_USERS_REQUEST:
            return {
                ...state,
                loading: true
            }
        case FETCH_USERS_SUCCESS:
            return {
                loading: false,
                users: action.payload,
                error: ''
            }
        case FETCH_USERS_ERROR:
            return {
                loading: false,
                users: [],
                error: action.payload
            }
        case ADD_AGENT_REQUEST:
            return {
                ...state,
                loading: true
            }
        case ADD_AGENT_SUCCESS:
            return {
                ...state,
                loading: false,
                error: ''
            }
        case ADD_AGENT_ERROR:
            return {
                ...state,
                loading: false,
                error: action.payload
            }
        case CHANGE_USER_STATE_REQUEST:
            return {
                ...state,
                loading: true
            }
        case CHANGE_USER_STATE_SUCCESS:
            return {
                ...state,
                loading: false,
                error: ''
            }
        case CHANGE_USER_STATE_ERROR:
            return {
                ...state,
                loading: false,
                error: action.payload
            }
        default: return initialState
    }
}
export default usersReducer