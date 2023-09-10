import { useContext, useState } from 'react';
import { Image } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import { MyUserContext } from "../App";
import React from 'react';

import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link, useNavigate } from 'react-router-dom';

const Header = () => {
    const [user, dispatch] = useContext(MyUserContext);

    const [kw, setKw] = useState("");
    const nav = useNavigate();
    const searchPost = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`);
    }

    const logout = () => {
        dispatch({
            "type": "logout"
        })
    }

    return (<Navbar expand="lg" className="bg-body-tertiary">
        <Container>
            <Navbar.Brand href="#">
                <img src='https://www.tromoi.com/logo_text_blue.png' style={{ width: '100px' }} />
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="navbarScroll" />
            <Navbar.Collapse id="navbarScroll">
                <Nav
                    className="me-auto my-2 my-lg-0"
                    style={{ maxHeight: '100px' }}
                    navbarScroll
                >
                    <Nav.Link as={Link} to="/">Home</Nav.Link>
                    <Nav.Link as={Link} to="/MyPage">MyPage</Nav.Link>
                    {user === null ?
                        <Link className="text-success nav-link" to="/login">Đăng nhập</Link> :
                        <React.Fragment>
                            <Link className="text-danger nav-link" to="/">Chào {user.username}!</Link>
                            <Button variant="danger" onClick={logout}>Đăng xuất</Button>
                        </React.Fragment>}

                    <Nav.Link as={Link} to="/Register">Register</Nav.Link>

                  
                </Nav>
                <Form onSubmit={searchPost} className="d-flex">
                    <Form.Control
                        type="search"
                        placeholder="Search"
                        value={kw}
                        onChange={e => setKw(e.target.value)}
                        className="me-2"
                        aria-label="Search"
                    />
                    <Button type='submit' variant="outline-success">Search</Button>
                </Form>
            </Navbar.Collapse>
        </Container>
    </Navbar>
    )
}
export default Header;