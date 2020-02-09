import { 
    FETCH_RESERVATIONS_REQUEST,
    FETCH_RESERVATIONS_SUCCESS,
    FETCH_RESERVATIONS_ERROR,
    CREATE_RESERVATION_REQUEST,
    CREATE_RESERVATION_SUCCESS,
    CREATE_RESERVATION_ERROR,
    DELETE_RESERVATION_REQUEST,
    DELETE_RESERVATION_SUCCESS,
    DELETE_RESERVATION_ERROR
} from './reservationTypes'

const initialState = {
    loading: false,
    reservations: [],
    error: ''
}

const reservationReducer = (state = initialState, action) => {
    switch(action.type) {
        case FETCH_RESERVATIONS_REQUEST:
            return {
                ...state,
                loading: true
            }
        case FETCH_RESERVATIONS_SUCCESS:
            return {
                loading: false,
                reservations: action.payload,
                error: ''
            }
        case FETCH_RESERVATIONS_ERROR:
            return {
                loading: false,
                reservations: [],
                error: action.payload
            }
        case CREATE_RESERVATION_REQUEST:
            return {
                ...state,
                loading: true
            }
        case CREATE_RESERVATION_SUCCESS:
            return {
                ...state,
                loading: false,
                error: ''
            }
        case CREATE_RESERVATION_ERROR:
            return {
                ...state,
                loading: false,
                error: action.payload
            }
        case DELETE_RESERVATION_REQUEST:
            return {
                ...state,
                loading: true
            }
        case DELETE_RESERVATION_SUCCESS:
            return {
                ...state,
                loading: false,
                error: ''
            }
        case DELETE_RESERVATION_ERROR:
            return {
                ...state,
                loading: false,
                error: action.payload
            }
        default: return state
    }
}

export default reservationReducer