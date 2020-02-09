import React from 'react'

function ApartmentContainer(apartment) {
    return (
        <div className='element'>
            <table><tbody>
                <tr><td colSpan="2">{ apartment.city }, { apartment.address }</td></tr>
                <tr><td>Minimum guests:</td><td>{ apartment.capacity }</td></tr>
                <tr><td>Price per night:</td><td>{ apartment.price }</td></tr>
                <tr><td>{ apartment.cancelable ? 'Can be canceled' : 'Can\'t be canceled' }</td></tr>
                <tr><td>Category:</td><td>{ apartment.category.name }</td></tr>
                <tr><td>Type:</td><td>{ apartment.type.name }</td></tr>
            </tbody></table>
        </div>
    )
}

export default ApartmentContainer
