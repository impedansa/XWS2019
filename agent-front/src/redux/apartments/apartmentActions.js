import axios from 'axios'
import { FETCH_APARTMENTS_REQUEST, FETCH_APARTMENTS_SUCCESS, FETCH_APARTMENTS_ERROR, RESET_APARTMENTS, CREATE_APARTMENT_REQUEST, CREATE_APARTMENT_SUCCESS, CREATE_APARTMENT_ERROR } from './apartmentTypes'

export const fetchApartments = () => {
    return (dispatch) => {
        dispatch(fetchApartmentsRequest())
        axios.get('http://localhost:8081/apartments')
            .then((response) => {
                dispatch(fetchApartmentsSuccess(response.data))
            })
            .catch((error) => {
                dispatch(fetchApartmentsError(error.message))
            })
    }
}

export const fetchApartmentsRequest = () => {
    return {
        type: FETCH_APARTMENTS_REQUEST
    }
}

export const fetchApartmentsSuccess = (apartments) => {
    return {
        type: FETCH_APARTMENTS_SUCCESS,
        payload: apartments
    }
}

export const fetchApartmentsError = (error) => {
    return {
        type: FETCH_APARTMENTS_ERROR,
        payload: error
    }
}

export const createApartment = (apartment) => {
    return (dispatch) => {
        dispatch(createApartmentRequest())
        axios.post('http://localhost:8081/apartments', apartment)
            .then((response) => {
                dispatch(createApartmentSuccess(response.data))
            })
            .catch((error) => {
                dispatch(createApartmentError(error.message))
            })
    }
}

export const createApartmentRequest = () => {
    return {
        type: CREATE_APARTMENT_REQUEST
    }
}

export const createApartmentSuccess = (apartment) => {
    return {
        type: CREATE_APARTMENT_SUCCESS,
        payload: apartment
    }
}

export const createApartmentError = (error) => {
    return {
        type: CREATE_APARTMENT_ERROR,
        payload: error
    }
}

export const resetApartments = () => {
    return {
        type: RESET_APARTMENTS
    }
}