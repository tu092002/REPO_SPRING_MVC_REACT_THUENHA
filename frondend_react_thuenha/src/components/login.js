import { useContext, useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import cookie from "react-cookies";
import { Navigate } from "react-router-dom";
import { MyUserContext } from "../App";
import Apis, { authApi, endpoints } from "../configs/Apis";
import React from 'react';
import {
    MDBBtn,
    MDBContainer,
    MDBCard,
    MDBCardBody,
    MDBCardImage,
    MDBRow,
    MDBCol,
    MDBIcon,
    MDBInput
}
    from 'mdb-react-ui-kit';
const Login = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();

    const login = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {
                let res = await Apis.post(endpoints['login'], {
                    "username": username,
                    "password": password
                });

                console.info(res.data);
                cookie.save("token", res.data);

                let { data } = await authApi().get(endpoints['current-user']);
                cookie.save("user", data);

                dispatch({
                    "type": "login",
                    "payload": data
                });

            } catch (ex) {
                console.error(ex);
            }

        }

        process();
    }

    if (user !== null)
        return <Navigate />

    return (<Container>
        <h1 className="text-center text-info mt-2">ĐĂNG NHẬP NGƯỜI DÙNG</h1>
       

        <Form onSubmit={login}>

            <MDBContainer className="my-5">

                <MDBCard>
                    <MDBRow className='g-0'>

                        <MDBCol md='6'>
                            <MDBCardImage src='https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp' alt="login form" className='rounded-start w-100' />
                        </MDBCol>

                        <MDBCol md='6'>
                            <MDBCardBody className='d-flex flex-column'>

                                <div className='d-flex flex-row mt-2'>
                                    <MDBIcon fas icon="cubes fa-3x me-3" style={{ color: '#ff6219' }} />
                                    <span className="h1 fw-bold mb-0">Logo</span>
                                </div>

                                <h5 className="fw-normal my-4 pb-3" style={{ letterSpacing: '1px' }}>Sign into your account</h5>

                                <MDBInput wrapperClass='mb-4' label='Email address'  type='text`' size="lg" value={username}
                                    onChange={e => setUsername(e.target.value)}
                                    placeholder="username" />
                                <MDBInput wrapperClass='mb-4' label='Password'  type='password' size="lg" value={password}
                                    onChange={e => setPassword(e.target.value)}
                                    placeholder="password" />

                                <MDBBtn className="mb-4 px-5" type="submit" color='dark' size='lg'>Đăng Nhập</MDBBtn>
                                <a className="small text-muted" href="#!">Forgot password?</a>
                                <p className="mb-5 pb-lg-2" style={{ color: '#393f81' }}>Don't have an account? <a href="#!" style={{ color: '#393f81' }}>Register here</a></p>

                                <div className='d-flex flex-row justify-content-start'>
                                    <a href="#!" className="small text-muted me-1">Terms of use.</a>
                                    <a href="#!" className="small text-muted">Privacy policy</a>
                                </div>

                            </MDBCardBody>
                        </MDBCol>

                    </MDBRow>
                </MDBCard>

            </MDBContainer>
        </Form>

    </Container>)
}

export default Login;