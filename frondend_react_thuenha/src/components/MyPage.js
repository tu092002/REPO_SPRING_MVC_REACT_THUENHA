

import React, { useContext, useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Card from 'react-bootstrap/Card';
import Apis, { endpoints } from '../configs/Apis';
import { Image, Spinner } from 'react-bootstrap';
import { MyUserContext } from '../App';
import { MDBCol, MDBContainer, MDBRow, MDBCard, MDBCardText, MDBCardBody, MDBCardImage, MDBBtn, MDBTypography } from 'mdb-react-ui-kit';

const MyPage = () => {
    const [user, dispatch] = useContext(MyUserContext);

    const loadUsers = async () => {
        // try {
        //     // cách 1 nạp api thoog qua cáu hình apis
        //     let res = await Apis.get(endpoints['user']);
        //     // cách 2 thong qua fetch
        //     // let res = await fetch("http://localhost:8080/SpringMVCThueNha1/api/user/")

        //     // let data = await res.json();

        //     setUser(res.data);
        // }
        // catch (ex) {
        //     console.error(ex)
        // }

    }
    // useEffect(() => {
    //     loadUsers();
    // }, []);
    if (user === null) {

        return <Spinner animation="grow" variant="info" />

    }


    return (
        <div>
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="#home">My Blog</Navbar.Brand>
            </Navbar>
            <Container className="mt-4">

                <Row>
                  
                    <Col md={12}>
                        <div className="gradient-custom-2" style={{ backgroundColor: 'rgb(202, 206, 209)' }}>
                            <MDBContainer className="py-5 h-100">
                                <MDBRow className="justify-content-center align-items-center h-100">
                                    <MDBCol lg="9" xl="7">
                                        <MDBCard>
                                            <div className="rounded-top text-white d-flex flex-row" style={{ backgroundColor: '#000', height: '200px' }}>
                                                <div className="ms-4 mt-5 d-flex flex-column" style={{ width: '150px' }}>
                                                    <MDBCardImage src={user.avatar}
                                                        alt="Generic placeholder image" className="mt-4 mb-2 img-thumbnail" fluid style={{ width: '150px', zIndex: '1' }} />
                                                    <MDBBtn outline color="dark" style={{ height: '36px', overflow: 'visible' }}>
                                                        Edit profile
                                                    </MDBBtn>
                                                </div>
                                                <div className="ms-3" style={{ marginTop: '130px' }}>
                                                    <MDBTypography tag="h5">{user.hoten}</MDBTypography>
                                                    <MDBCardText>{user.address}</MDBCardText>
                                                </div>
                                            </div>
                                            <div className="p-4 text-black" style={{ backgroundColor: '#f8f9fa' }}>
                                                <div className="d-flex justify-content-end text-center py-1">
                                                    <div>
                                                        <MDBCardText className="mb-1 h5">253</MDBCardText>
                                                        <MDBCardText className="small text-muted mb-0">Photos</MDBCardText>
                                                    </div>
                                                    <div className="px-3">
                                                        <MDBCardText className="mb-1 h5">1026</MDBCardText>
                                                        <MDBCardText className="small text-muted mb-0">Followers</MDBCardText>
                                                    </div>
                                                    <div>
                                                        <MDBCardText className="mb-1 h5">478</MDBCardText>
                                                        <MDBCardText className="small text-muted mb-0">Following</MDBCardText>
                                                    </div>
                                                </div>
                                            </div>
                                            <MDBCardBody className="text-black p-4">
                                                <div className="mb-5">
                                                    <p className="lead fw-normal mb-1">About</p>
                                                    <div className="p-4" style={{ backgroundColor: '#f8f9fa' }}>
                                                        <MDBCardText className="font-italic mb-1">Web Developer</MDBCardText>
                                                        <MDBCardText className="font-italic mb-1">Lives in New York</MDBCardText>
                                                        <MDBCardText className="font-italic mb-0">Photographer</MDBCardText>
                                                    </div>
                                                </div>
                                                <div className="d-flex justify-content-between align-items-center mb-4">
                                                    <MDBCardText className="lead fw-normal mb-0">Recent photos</MDBCardText>
                                                    <MDBCardText className="mb-0"><a href="#!" className="text-muted">Show all</a></MDBCardText>
                                                </div>
                                                <MDBRow>
                                                    <MDBCol className="mb-2">
                                                        <MDBCardImage src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(112).webp"
                                                            alt="image 1" className="w-100 rounded-3" />
                                                    </MDBCol>
                                                    <MDBCol className="mb-2">
                                                        <MDBCardImage src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(107).webp"
                                                            alt="image 1" className="w-100 rounded-3" />
                                                    </MDBCol>
                                                </MDBRow>
                                                <MDBRow className="g-2">
                                                    <MDBCol className="mb-2">
                                                        <MDBCardImage src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(108).webp"
                                                            alt="image 1" className="w-100 rounded-3" />
                                                    </MDBCol>
                                                    <MDBCol className="mb-2">
                                                        <MDBCardImage src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(114).webp"
                                                            alt="image 1" className="w-100 rounded-3" />
                                                    </MDBCol>
                                                </MDBRow>
                                            </MDBCardBody>
                                        </MDBCard>
                                    </MDBCol>
                                </MDBRow>
                            </MDBContainer>
                        </div>
                    </Col>
                </Row>
            </Container>
        </div>
    )

}

export default MyPage;
