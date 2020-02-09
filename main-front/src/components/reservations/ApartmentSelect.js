import React from 'react'
import { connect } from 'react-redux'

function ApartmentSelect({
    apartmentsState,
    handleSelect
}) {
    return (
        <select style={ { fontSize: 'x-large', fontFamily: '\'Times New Roman\', Times, serif' } } onChange={ (e) => handleSelect(parseInt(e.target.value)) }>
            {
                apartmentsState &&
                apartmentsState.apartments &&
                apartmentsState.apartments.map((apartment) => <option value={ apartment.id } >{ apartment.city }, { apartment.address }</option>)
            }
        </select>
    )
}

const mapStateToProps = (state) => {
    return {
        apartmentsState: state.apartmentsState
    }
}

export default connect(
    mapStateToProps,
    null
)(ApartmentSelect)
