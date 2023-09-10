import React, { useEffect, useRef, useState } from "react";
import Apis, { endpoints } from "../configs/Apis";
import { Col, Container, Image, Row, Spinner, CarouselProps, Carousel, Card, Button, Alert, Form } from "react-bootstrap";
import { Link, useSearchParams } from "react-router-dom";
import "../static/css/Home.css";
import { useContext } from "react";
import { useNavigate } from "react-router-dom";

import { MyUserContext } from "../App";

function ConditionalComponent({ condition, countPost }) {
    return (
        <div>
            {condition === 1 && <p>Kết quả tìm kiếm là: {countPost}</p>}
            {condition === 0 && <p>This is rendered when the condition is false.</p>}
        </div>
    );
}
const Home = () => {

    // const [showComponent,setShowComponent] = useState[0];
    const imgPost = useRef();
    const [user, dispatch] = useContext(MyUserContext);

    const nav = useNavigate();
    const [err, setErr] = useState()

    const [loading, setLoading] = useState(false);
    const [postOne, setPostOne] = useState({
        "titlePost": "",
        "addressPost": "",
        "giaTien": "",
        "idUser": user,
    });
    const [posts, setPosts] = useState(null);
    const [users, setUsers] = useState(null);
    const [q] = useSearchParams();
    let kw = null;
    const loadUsers = async () => {
        try {
            // cách 1 nạp api thoog qua cáu hình apis
            let res = await Apis.get(endpoints['user']);
            // cách 2 thong qua fetch
            // let res = await fetch("http://localhost:8080/SpringMVCThueNha1/api/user/")

            // let data = await res.json();

            setUsers(res.data);


        }
        catch (ex) {
            console.error(ex)
        }

    }
    useEffect(() => {
        loadUsers();
    }, []);

    function getUserByPost(id) {
        user.map(u => {
            if (u.IdUser == id) {
                return u.avatar;
            }
        })
    }

    const loadPosts = async () => {
        try {
            let e = endpoints['posts'];
            kw = q.get('kw');
            if (kw !== null) {
                e = `${e}?kw=${kw}`

            }
            // cách 1 nạp api thoog qua cáu hình apis
            let res = await Apis.get(e);
            // cách 2 thong qua fetch
            // let res = await fetch("http://localhost:8080/SpringMVCThueNha1/api/posts/")

            // let data = await res.json();

            setPosts(res.data);
        }
        catch (ex) {

        }


    }
    const createPost = (evt) => {
        evt.preventDefault();
        const process = async () => {
            let form = new FormData();


            for (let field in postOne) {

                form.append(field, postOne[field]);
            }
            form.append("imgPost", imgPost.current.files[0]);
            setLoading(true)

            let res = await Apis.post(endpoints['posts'], form);
            if (res.status === 201)
                nav("/");
            else
                setErr("Hệ thống bị lỗi!");
        }
        process();
    }
    useEffect(() => {
        loadPosts();
    }, [q]);
    // if (posts.length === 0)
    //     return <Alert variant="info" className="mt-1">Không có bài đăng nào phù hợp!</Alert>

    if (posts === null) {

        return <Spinner animation="grow" variant="info" />

    }
    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        setPostOne(current => {
            return { ...current, [field]: evt.target.value }
        })
    }


    return (
        <Container className="bg1 mt-1">

            <Row>
                <Col>
                    <div class="post-container">
                        <div class="user-avatar">
                            <Image
                                width={200}
                                height={200}
                                src={user != null ? user.avatar : "rỗngAvt"}
                                // alt="Hình ảnh bo tròn avt"
                                roundedCircle // Sử dụng lớp CSS rounded-circle
                            />
                        </div>

                        <Form className="post-content" method="post" onSubmit={createPost}>
                            <Form.Group className="mb-3">
                                <Form.Label>titlePost</Form.Label>
                                <Form.Control type="text" value={postOne.titlePost} onChange={(e) => change(e, "titlePost")} placeholder="tiêu đề " required />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>giaTien</Form.Label>
                                <Form.Control type="number" value={postOne.giaTien} onChange={(e) => change(e, "giaTien")} placeholder="giá tiền " required />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>addressPost</Form.Label>
                                <Form.Control type="text" value={postOne.addressPost} onChange={(e) => change(e, "addressPost")} placeholder="địa chỉ " required />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Ảnh Nhà thuê</Form.Label>
                                <Form.Control type="file" ref={imgPost} />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Button variant="info" type="submit">Post bài</Button>
                            </Form.Group>
                        </Form>
                    </div>

                </Col>

            </Row>
            <Row>
                {
                    posts.map(c => {
                        let url = `posts/${c.idPost}`;
                        return (<Col xs={6} md={6} key={c.idPost}>
                            <Card >
                                <Card.Body>

                                    <Image
                                        width={50}
                                        height={50}
                                        src={c.idUser.avatar}
                                        alt="Hình ảnh bo tròn avt"
                                        roundedCircle // Sử dụng lớp CSS rounded-circle
                                    />
                                    <Card.Title>{c.titlePost}</Card.Title>
                                    <Card.Text>{c.giaTien} VNĐ</Card.Text>
                                    <Card.Text>{c.createPost}</Card.Text>

                                </Card.Body>
                                <Carousel >
                                    <Carousel.Item interval={3000}>
                                        <img variant="top" src={c.imgPost} style={{ height: '300px', width: '500px' }} />

                                        <Carousel.Caption>
                                            <h3>{c.addressPost}</h3>
                                        </Carousel.Caption>
                                    </Carousel.Item>
                                    <Carousel.Item interval={3000} >
                                        <img variant="top" src={c.imgPost} style={{ height: '300px', width: '500px' }} />
                                        <Carousel.Caption>
                                            <h3>{c.addressPost}</h3>

                                        </Carousel.Caption>
                                    </Carousel.Item>
                                    <Carousel.Item>
                                        <img variant="top" src={c.imgPost} style={{ height: '300px', width: '1300px' }} />
                                        <Carousel.Caption>
                                            <h3>{c.addressPost}</h3>

                                        </Carousel.Caption>
                                    </Carousel.Item>
                                </Carousel>
                                <Link to={url} className="btn btn-danger">Xem chi tiết</Link>
                            </Card>

                        </Col>
                        )
                    }
                    )
                }
            </Row>
        </Container>
    )

}
export default Home