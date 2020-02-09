import {
    FETCH_TYPES_REQUEST,
    FETCH_TYPES_SUCCESS,
    FETCH_TYPES_ERROR,
    ADD_TYPE_REQUEST,
    ADD_TYPE_SUCCESS,
    ADD_TYPE_ERROR,
    DELETE_TYPE_REQUEST,
    DELETE_TYPE_SUCCESS,
    DELETE_TYPE_ERROR
} from './apartmentTypesTypes'

const initialState = {
    loading: true,
    types: [],
    error: ''
}

const typesReducer = (state = initialState, action) => {
    switch(action.type) {
        case FETCH_TYPES_REQUEST:
            return {
                ...state,
                loading: true
            }
        case FETCH_TYPES_SUCCESS:
            return {
                ...state,
                loading: false,
                error: '',
                types: action.payload
            }
        case FETCH_TYPES_ERROR:
            return {
                ...state,
                loading: false,
                types: [],
                error: action.payload
            }
        case ADD_TYPE_REQUEST:
            return {
                ...state,
                loading: true
            }
        case ADD_TYPE_SUCCESS:
            return {
                ...state,
                loading: false,
                error: ''
            }
        case ADD_TYPE_ERROR:
            return {
                ...state,
                loading: false,
                error: action.payload
            }
        case DELETE_TYPE_REQUEST:
            return {
                ...state,
                loading: true
            }
        case DELETE_TYPE_SUCCESS:
            return {
                ...state,
                loading: false,
                error: ''
            }
        case DELETE_TYPE_ERROR:
            return {
                ...state,
                loading: false,
                error: action.payload
            }
        default: return state
    }
}

export default typesReducer