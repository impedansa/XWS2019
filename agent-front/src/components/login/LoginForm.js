import React, { useState } from 'react'
import { connect } from 'react-redux'
import { login } from '../../redux'
import { LOGIN } from '../../redux/router/routerPaths'

function LoginForm({
    loginState,
    page,
    login
}) {

    const [ email, setEmail ] = useState('')
    const [ password, setPassword ] = useState('')

    const handleLogin = (event) => {
        event.preventDefault()
        login(email, password)
        setEmail('')
        setPassword('')
    }

    return page === LOGIN && loginState.user == null ? (
        <div>
            <form>
                <table>
                    <tbody>
                        <tr>
                            <td>Email:</td>
                            <td><input type='email' value={ email } onChange={ e => setEmail(e.target.value) } /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type='password' value={ password } onChange={ e => setPassword(e.target.value) } /></td>
                        </tr>
                        <tr>
                            <td></td><td><input type='button' onClick={ (e) => handleLogin(e) } value='Login' /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    ) : ''
}

const mapStateToProps = (state) => {
    return {
        loginState: state.loginState,
        page: state.route.page
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        login: (email, password) => dispatch(login({email: email, password: password}))
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(LoginForm)
