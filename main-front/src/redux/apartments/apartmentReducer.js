import { FETCH_APARTMENTS_REQUEST, FETCH_APARTMENTS_SUCCESS, FETCH_APARTMENTS_ERROR } from './apartmentTypes'

const initialState = {
    loading: false,
    apartments: [],
    error: ''
}

const apartmentReducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_APARTMENTS_REQUEST:
          return {
            ...state,
            loading: true
          }
        case FETCH_APARTMENTS_SUCCESS:
          return {
            loading: false,
            apartments: action.payload,
            error: ''
          }
        case FETCH_APARTMENTS_ERROR:
          return {
            loading: false,
            users: [],
            error: action.payload
          }
        default: return state
    }
}

export default apartmentReducer