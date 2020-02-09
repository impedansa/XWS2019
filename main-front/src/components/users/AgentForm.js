import React, { useState } from 'react'
import { connect } from 'react-redux'
import { addAgent } from '../../redux'

function AgentForm({
    addAgent
}) {
    const [ name, setName ] = useState('')
    const [ email, setEmail ] = useState('')
    const [ password, setPassword ] = useState('')
    const [ phoneNumber, setPhoneNumber ] = useState('')
    const [ birthday, setBirthday ] = useState(new Date())

    const handleCreate = (event) => {
        event.preventDefault()
        addAgent({
            name,
            email,
            password,
            phoneNumber,
            birthday
        })
    }

    return (
        <div>
            <form>
                <table>
                    <tbody>
                        <tr>
                            <td>Name:</td>
                            <td><input type='text' value={ name } onChange={ e => setName(e.target.value) } /></td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input type='email' value={ email } onChange={ e => setEmail(e.target.value) } /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type='password' value={ password } onChange={ e => setPassword(e.target.value) } /></td>
                        </tr>
                        <tr>
                            <td>Phone:</td>
                            <td><input type='text' value={ phoneNumber } onChange={ e => setPhoneNumber(e.target.value) } /></td>
                        </tr>
                        <tr>
                            <td>Date of birth:</td>
                            <td><input type='date' value={ birthday } onChange={ (e) => setBirthday(e.target.value) } /></td>
                        </tr>
                        <tr>
                            <td></td><td><input type='button' onClick={ (e) => handleCreate(e) } value='Add agent' /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    )
}

const mapDispatchToProps = (dispatch) => {
    return {
        addAgent: (agent) => dispatch(addAgent(agent))
    }
}

export default connect(
    null,
    mapDispatchToProps
)(AgentForm)
