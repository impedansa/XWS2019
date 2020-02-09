import axios from 'axios'
import { LOGIN_REQUEST, LOGIN_SUCCES, LOGIN_ERROR, LOGOUT_REQUEST, LOGOUT_SUCCESS, LOGOUT_ERROR } from './loginTypes'
import { pageChange } from '../router/routerActions'
import { APARTMENTS } from '../router/routerPaths'

export const login = (loginData) => {
    return (dispatch) => {
        dispatch(loginRequest())
        axios.post('http://localhost:8762/user-service/login', loginData)
            .then((response) => {
                dispatch(loginSuccess(response.data))
                dispatch(pageChange(APARTMENTS))
            })
            .catch((error) => {
                dispatch(loginError(error.message))
            })
    }
}

export const loginRequest = () => {
    return {
        type: LOGIN_REQUEST
    }
}

export const loginSuccess = (user) => {
    return {
        type: LOGIN_SUCCES,
        payload: user
    }
}

export const loginError = (error) => {
    return {
        type: LOGIN_ERROR,
        payload: error
    }
}

export const logout = () => {
    return (dispatch) => {
        dispatch(logoutRequest())
        dispatch(logoutSuccess())
        dispatch(logoutError())
    }
}

export const logoutRequest = () => {
    return {
        type: LOGOUT_REQUEST
    }
}

export const logoutSuccess = () => {
    return {
        type: LOGOUT_SUCCESS
    }
}

export const logoutError = () => {
    return {
        type: LOGOUT_ERROR
    }
}