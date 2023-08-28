import { useState } from 'react';
import { Image } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link,useNavigate } from 'react-router-dom';

const Header = () => {

    const [kw, setKw] = useState("");
    const nav = useNavigate();
    const searchPost = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`);
    }



    return (<Navbar expand="lg" className="bg-body-tertiary">
        <Container>
            <Navbar.Brand href="#">
            <img src='https://www.tromoi.com/logo_text_blue.png' style={{width: '100px'}} />
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
                    <Nav.Link as={Link} to="/login">Login</Nav.Link>
                    <NavDropdown title="Link" id="navbarScrollingDropdown">
                        <NavDropdown.Item href="#action3">Action</NavDropdown.Item>
                        <NavDropdown.Item href="#action4">
                            Another action
                        </NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#action5">
                            Something else here
                        </NavDropdown.Item>
                    </NavDropdown>
                    <Nav.Link href="#" disabled>
                        Link
                    </Nav.Link>
                </Nav>
                <Form onSubmit={searchPost} className="d-flex">
                    <Form.Control
                        type="search"
                        placeholder="Search"
                        value = {kw}
                        onChange={e => setKw(e.target.value )}
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