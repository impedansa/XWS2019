import React, { useState } from 'react'
import { connect } from 'react-redux'
import CategorySelect from './CategorySelect'
import TypeSelect from './TypeSelect'
import { createApartment } from '../../redux'

function ApartmentForm({
    createApartment
}) {

    const [capacity, setCapacity] = useState(0)
    const [price, setPrice] = useState(0)
    const [city, setCity] = useState('')
    const [address, setAddress] = useState('')
    const [cancelable, setCancelable] = useState(false)
    const [category, setCategory] = useState(0)
    const [type, setType] = useState(0)

    const handleCreate = (event) => {
        event.preventDefault()
        createApartment({
            city,
            address,
            price,
            capacity,
            cancelable,
            type: {id: type},
            category: {id: category}
        })
    }

    return (
        <form>
            <div>
                <table><tbody>
                    <tr><td>City:</td><td><input type='text' value={ city } onChange={ (e) => setCity(e.target.value) } /></td></tr>
                    <tr><td>Address:</td><td><input type='text' value={ address } onChange={ (e) => setAddress(e.target.value) } /></td></tr>
                    <tr><td>Price:</td><td><input type='number' value={ price } onChange={ (e) => setPrice(parseFloat(e.target.value)) } /></td></tr>
                    <tr><td>Maximum guests:</td><td><input type='number' value={ capacity } onChange={ (e) => setCapacity(parseInt(e.target.value)) } /></td></tr>
                    <tr><td>Cancelable:</td><td><input type='checkbox' value={ cancelable } onChange={ (e) => setCancelable(!cancelable) } /></td></tr>
                    <tr><td>Category:</td><td><CategorySelect handleSelect={ (category) => setCategory(category) } /></td></tr>
                    <tr><td>Type:</td><td><TypeSelect handleSelect={ (type) => setType(type) } /></td></tr>
                    <tr><td></td><td><input type='button' value='Create' onClick={ (e) => handleCreate(e) } /></td></tr>
                </tbody></table>
            </div>
        </form>
    )
}

const mapDispatchToProps = (dispatch) => {
    return {
        createApartment: (apartment) => dispatch(createApartment(apartment))
    }
}

export default connect(
    null,
    mapDispatchToProps
)(ApartmentForm)
