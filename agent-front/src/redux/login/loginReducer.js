import { LOGIN_REQUEST, LOGIN_SUCCES, LOGIN_ERROR, LOGOUT_REQUEST, LOGOUT_SUCCESS, LOGOUT_ERROR } from './loginTypes'

const initialState = {
    loading: false,
    user: null,
    error: ''
}

const loginReducer = (state = initialState, action) => {
    switch (action.type) {
        case LOGIN_REQUEST:
          return {
            ...state,
            loading: true
          }
        case LOGIN_SUCCES:
          return {
            loading: false,
            user: action.payload,
            error: ''
          }
        case LOGIN_ERROR:
          return {
            loading: false,
            user: null,
            error: action.payload
          }
        case LOGOUT_REQUEST:
          return {
            ...state,
            loading: true
          }
        case LOGOUT_SUCCESS:
          return  {
            loading: false,
            user: null,
            error: ''
          }
        case LOGOUT_ERROR:
          return {
            ...state,
            loading: false
          }
        default: return state
    }
}

export default loginReducer