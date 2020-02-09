import {
    FETCH_CATEGORIES_REQUEST,
    FETCH_CATEGORIES_SUCCESS,
    FETCH_CATEGORIES_ERROR,
    ADD_CATEGORY_REQUEST,
    ADD_CATEGORY_SUCCESS,
    ADD_CATEGORY_ERROR,
    DELETE_CATEGORY_REQUEST,
    DELETE_CATEGORY_SUCCESS,
    DELETE_CATEGORY_ERROR
} from './apartmentCategoriesTypes'

const initialState = {
    loading: true,
    categories: [],
    error: ''
}

const categoriesReducer = (state = initialState, action) => {
    switch(action.type) {
        case FETCH_CATEGORIES_REQUEST:
            return {
                ...state,
                loading: true
            }
        case FETCH_CATEGORIES_SUCCESS:
            return {
                ...state,
                loading: false,
                error: '',
                categories: action.payload
            }
        case FETCH_CATEGORIES_ERROR:
            return {
                ...state,
                loading: false,
                categories: [],
                error: action.payload
            }
        case ADD_CATEGORY_REQUEST:
            return {
                ...state,
                loading: true
            }
        case ADD_CATEGORY_SUCCESS:
            return {
                ...state,
                loading: false,
                error: ''
            }
        case ADD_CATEGORY_ERROR:
            return {
                ...state,
                loading: false,
                error: action.payload
            }
        case DELETE_CATEGORY_REQUEST:
            return {
                ...state,
                loading: true
            }
        case DELETE_CATEGORY_SUCCESS:
            return {
                ...state,
                loading: false,
                error: ''
            }
        case DELETE_CATEGORY_ERROR:
            return {
                ...state,
                loading: false,
                error: action.payload
            }
        default: return state
    }
}

export default categoriesReducer