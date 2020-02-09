import { FETCH_TYPES_REQUEST, FETCH_TYPES_SUCCESS, FETCH_TYPES_ERROR } from './apartmentTypesTypes'

const initialState = {
    loading: false,
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
                loading: false,
                types: action.payload,
                error: ''
            }
        case FETCH_TYPES_ERROR:
            return {
                loading: false,
                types: [],
                error: action.payload
            }
        default: return state
    }
}

export default typesReducer