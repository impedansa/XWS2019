import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchTypes } from '../../redux'

function CategorySelect({
    typesState,
    fetchTypes,
    handleSelect
}) {
    useEffect(() => {
        fetchTypes()
    }, [fetchTypes])

    return (
        <select style={ { fontSize: 'x-large', fontFamily: '\'Times New Roman\', Times, serif' } } onChange={ (e) => handleSelect(parseInt(e.target.value)) }>
            {
                typesState &&
                typesState.types &&
                typesState.types.map((type) => <option value={ type.id }>{ type.name }</option>)
            }
        </select>
    )
}

const mapStateToProps = (state) => {
    return {
        typesState: state.typesState
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchTypes: () => dispatch(fetchTypes())
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(CategorySelect)
