import axios from 'axios'
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

export const fetchTypes = () => {
    return (dispatch) => {
        dispatch(fetchTypesRequest())
        axios.get('http://localhost:8762/apartments-service/types')
            .then((response) => {
                dispatch(fetchTypesSuccess(response.data))
            })
            .catch((error) => {
                dispatch(fetchTypesError(error.message))
            })
    }
}  

export const fetchTypesRequest = () => {
    return {
        type: FETCH_TYPES_REQUEST
    }
}

export const fetchTypesSuccess = (categories) => {
    return {
        type: FETCH_TYPES_SUCCESS,
        payload: categories
    }
}

export const fetchTypesError = (error) => {
    return {
        type: FETCH_TYPES_ERROR,
        payload: error
    }
}

export const addType = (type) => {
    return (dispatch) => {
        dispatch(addTypeRequest())
        axios.post('http://localhost:8762/apartments-service/types', type)
            .then((response) => {
                dispatch(addTypeSuccess(response.data))
            })
            .catch((error) => {
                dispatch(addTypeError(error.message))
            })
    }
}

export const addTypeRequest = () => {
    return {
        type: ADD_TYPE_REQUEST
    }
}

export const addTypeSuccess = (type) => {
    return {
        type: ADD_TYPE_SUCCESS,
        payload: type
    }
}

export const addTypeError = (error) => {
    return {
        type: ADD_TYPE_ERROR,
        payload: error
    }
}

export const deleteType = (type) => {
    return (dispatch) => {
        dispatch(deleteTypeRequest())
        axios.delete('http://localhost:8762/apartments-service/types/' + type)
            .then((response) => {
                dispatch(deleteTypeSuccess(response.data))
            })
            .catch((error) => {
                dispatch(deleteTypeError(error.message))
            })
    }
}

export const deleteTypeRequest = () => {
    return {
        type: DELETE_TYPE_REQUEST
    }
}

export const deleteTypeSuccess = (type) => {
    return {
        type: DELETE_TYPE_SUCCESS,
        payload: type
    }
}

export const deleteTypeError = (error) => {
    return {
        type: DELETE_TYPE_ERROR,
        payload: error
    }
}