import axios from 'axios'
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

export const fetchCategories = () => {
    return (dispatch) => {
        dispatch(fetchCategoriesRequest())
        axios.get('http://localhost:8762/apartments-service/categories')
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

export const addCategory = (category) => {
    return (dispatch) => {
        dispatch(addCategoryRequest())
        axios.post('http://localhost:8762/apartments-service/categories', category)
            .then((response) => {
                dispatch(addCategorySuccess(response.data))
            })
            .catch((error) => {
                dispatch(addCategoryError(error.message))
            })
    }
}

export const addCategoryRequest = () => {
    return {
        type: ADD_CATEGORY_REQUEST
    }
}

export const addCategorySuccess = (category) => {
    return {
        type: ADD_CATEGORY_SUCCESS,
        payload: category
    }
}

export const addCategoryError = (error) => {
    return {
        type: ADD_CATEGORY_ERROR,
        payload: error
    }
}

export const deleteCategory = (category) => {
    return (dispatch) => {
        dispatch(deleteCategoryRequest())
        axios.delete('http://localhost:8762/apartments-service/categories/' + category)
            .then((response) => {
                dispatch(deleteCategorySuccess(response.data))
            })
            .catch((error) => {
                dispatch(deleteCategoryError(error.message))
            })
    }
}

export const deleteCategoryRequest = () => {
    return {
        type: DELETE_CATEGORY_REQUEST
    }
}

export const deleteCategorySuccess = (category) => {
    return {
        type: DELETE_CATEGORY_SUCCESS,
        payload: category
    }
}

export const deleteCategoryError = (error) => {
    return {
        type: DELETE_CATEGORY_ERROR,
        payload: error
    }
}