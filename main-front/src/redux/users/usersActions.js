import axios from 'axios'
import {
    FETCH_USERS_REQUEST,
    FETCH_USERS_SUCCESS,
    FETCH_USERS_ERROR,
    CHANGE_USER_STATE_REQUEST,
    CHANGE_USER_STATE_SUCCESS,
    CHANGE_USER_STATE_ERROR,
    ADD_AGENT_REQUEST,
    ADD_AGENT_SUCCESS,
    ADD_AGENT_ERROR,
    REGISTER_REQUEST,
    REGISTER_SUCCESS,
    REGISTER_ERROR
} from './usersTypes'

export const fetchUsers = () => {
    return (dispatch) => {
        dispatch(fetchUsersRequest())
        axios.get('http://localhost:8762/user-service/users')
            .then((response) => {
                dispatch(fetchUsersSuccess(response.data))
            })
            .catch((error) => {
                dispatch(fetchUsersError(error.message))
            })
    }
}

export const fetchUsersRequest = () => {
    return {
        type: FETCH_USERS_REQUEST
    }
}

export const fetchUsersSuccess = (users) => {
    return {
        type: FETCH_USERS_SUCCESS,
        payload: users
    }
}

export const fetchUsersError = (error) => {
    return {
        type: FETCH_USERS_ERROR,
        payload: error
    }
}

export const changeUserState = (user, state) => {
    return (dispatch) => {
        dispatch(changeUserStateRequest())
        axios.post('http://localhost:8762/user-service/users/' + user + '/' + state)
            .then((response) => {
                dispatch(changeUserStateSuccess(response.data))
            })
            .catch((error) => {
                dispatch(changeUserStateError(error.message))
            })
    }
}

export const changeUserStateRequest = () => {
    return {
        type: CHANGE_USER_STATE_REQUEST
    }
}

export const changeUserStateSuccess = (user) => {
    return {
        type: CHANGE_USER_STATE_SUCCESS,
        payload: user
    }
}

export const changeUserStateError = (error) => {
    return {
        type: CHANGE_USER_STATE_ERROR,
        payload: error
    }
}

export const addAgent = (agent) => {
    return (dispatch) => {
        dispatch(addAgentRequest())
        axios.post('http://localhost:8762/user-service/agents', agent)
            .then((response) => {
                dispatch(addAgentSuccess(response.data))
            })
            .catch((error) => {
                dispatch(addAgentError(error.message))
            })
    }
}

export const addAgentRequest = () => {
    return {
        type: ADD_AGENT_REQUEST
    }
}

export const addAgentSuccess = (agent) => {
    return {
        type: ADD_AGENT_SUCCESS,
        payload: agent
    }
}

export const addAgentError = (error) => {
    return {
        type: ADD_AGENT_ERROR,
        payload: error
    }
}

export const register = (user) => {
    return (dispatch) => {
        dispatch(registerRequest())
        axios.post('http://localhost:8762/user-service/register', user)
            .then((response) => {
                dispatch(registerSuccess(response.data))
            })
            .catch((error) => {
                dispatch(registerError(error.message))
            })
    }
}

export const registerRequest = () => {
    return {
        type: REGISTER_REQUEST
    }
}

export const registerSuccess = (user) => {
    return {
        type: REGISTER_SUCCESS,
        payload: user
    }
}

export const registerError = (error) => {
    return {
        type: REGISTER_ERROR,
        payload: error
    }
}