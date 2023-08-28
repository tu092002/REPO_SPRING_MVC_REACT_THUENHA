

import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Card from 'react-bootstrap/Card';
import Apis, { endpoints } from '../configs/Apis';
import { Spinner } from 'react-bootstrap';

const MyPage = () => {

    const [user, setUser] = useState(null);
    const loadUsers = async () => {
        try {
            // cách 1 nạp api thoog qua cáu hình apis
            let res = await Apis.get(endpoints['user']);
            // cách 2 thong qua fetch
            // let res = await fetch("http://localhost:8080/SpringMVCThueNha1/api/user/")

            // let data = await res.json();

            setUser(res.data);
        }
        catch (ex) {
            console.error(ex)
        }

    }
    useEffect(() => {
        loadUsers();
    }, []);
    if (user === null) {

        return <Spinner animation="grow" variant="info" />

    }


    return (
        <div>
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="#home">My Blog</Navbar.Brand>
            </Navbar>
            <Container className="mt-4">
                {
                    user.map(u =>
                        <Row>
                            <Col md={8}>
                                <Card>
                                    <Card.Body>
                                        <Card.Title>Blog Post Title</Card.Title>
                                        <Card.Subtitle className="mb-2 text-muted">{u.username}</Card.Subtitle>
                                        <Card.Text>
                                            This is a sample blog post content. You can write your thoughts and ideas here.
                                        </Card.Text>
                                    </Card.Body>
                                </Card>
                            </Col>
                            <Col md={4}>
                                <Card>
                                    <Card.Body>
                                        <Card.Title>Recent Posts</Card.Title>
                                        <Card.Text>
                                            <ul>
                                                <li><a href="#">Post 1</a></li>
                                                <li><a href="#">Post 2</a></li>
                                                <li><a href="#">Post 3</a></li>
                                            </ul>
                                        </Card.Text>
                                    </Card.Body>
                                </Card>
                            </Col>
                        </Row>)
                }



            </Container>
        </div>
    )

}

export default MyPage;
