import axios from 'axios'
import { FETCH_CATEGORIES_REQUEST, FETCH_CATEGORIES_SUCCESS, FETCH_CATEGORIES_ERROR } from './categoriesTypes'

export const fetchCategories = () => {
    return (dispatch) => {
        dispatch(fetchCategoriesRequest())
        axios.get('http://localhost:8081/categories')
            .then((response) => {
                dispatch(fetchCategoriesSuccess(response.data))
            })
            .catch((error) => {
                dispatch(fetchCategoriesError(error.message))
            })
    }
}

export const fetchCategoriesRequest = () => {
    return {
        type: FETCH_CATEGORIES_REQUEST
    }
}

export const fetchCategoriesSuccess = (categories) => {
    return {
        type: FETCH_CATEGORIES_SUCCESS,
        payload: categories
    }
}

export const fetchCategoriesError = (error) => {
    return {
        type: FETCH_CATEGORIES_ERROR,
        payload: error
    }
}