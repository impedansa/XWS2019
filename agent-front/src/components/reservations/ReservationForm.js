import React, { useState } from 'react'
import { connect } from 'react-redux'
import { createReservation } from '../../redux'
import ApartmentSelect from './ApartmentSelect'

function ReservationForm({
    createReservation
}) {
    const [start, setStart] = useState(new Date())
    const [end, setEnd] = useState(new Date())
    const [apartment, setApartment] = useState(0)

    const handleCreate = (event) => {
        event.preventDefault()
        createReservation({
            apartment: {id: apartment},
            start: start,
            end: end
        })
    }

    return (
        <form>
            <div>
                <table><tbody>
                    <tr><td>Start:</td><td><input type='date' value={ start } onChange={ (e) => setStart(e.target.value) } /></td></tr>
                    <tr><td>End:</td><td><input type='date' value={ end } onChange={ (e) => setEnd(e.target.value) } /></td></tr>
                    <tr><td>Apartment:</td><td><ApartmentSelect handleSelect={ (apartment) => setApartment(apartment) } /></td></tr>
                    <tr><td></td><td><input type='button' value='Create' onClick={ (e) => handleCreate(e) } /></td></tr>
                </tbody></table>
            </div>
        </form>
    )
}

const mapDispatchToProps = (dispatch) => {
    return {
        createReservation: (reservation) => dispatch(createReservation(reservation))
    }
}

export default connect(
    null,
    mapDispatchToProps
)(ReservationForm)
