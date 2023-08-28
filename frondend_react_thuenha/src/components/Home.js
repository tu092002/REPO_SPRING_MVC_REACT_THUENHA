import { useEffect, useState } from "react";
import Apis, { endpoints } from "../configs/Apis";
import { Col, Container, Image, Row, Spinner, CarouselProps, Carousel, Card, Button, Alert } from "react-bootstrap";
import { useSearchParams } from "react-router-dom";


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
    
    const [posts, setPosts] = useState(null);
    const [q] = useSearchParams();
    let kw = null;
    const loadPosts = async () => {
        try {
            let e = endpoints['posts'];
            kw = q.get('kw');
            if (kw !== null) {
                e = `${e}?kw=${kw}`
                // setShowComponent(1);
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

    useEffect(() => {
        loadPosts();
    }, [q]);
    // if (posts.length === 0)
    //     return <Alert variant="info" className="mt-1">Không có bài đăng nào phù hợp!</Alert>
    
    if (posts === null) {

        return <Spinner animation="grow" variant="info" />

    }


    return (<Container>
        <h1>Home</h1>
        <Row>
            <Col>
            </Col>
        </Row>

        
        <Row>
            {
                posts.map(c =>
                    <Col xs={12} md={10} key={c.idPost}>
                        <Card >
                            <Card.Body>
                                <div style={{ width: '50px', height: '50px' }} className="bg-info rounded-circle d-flex justify-content-center">
                                    <span>
                                        <img style={{ width: '80%', height: '80%' }} className="" alt="avt" src='https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1200px-User-avatar.svg.png' />
                                    </span>
                                </div>
                                <Card.Title>{c.titlePost}</Card.Title>
                                <Card.Text>{c.giaTien} VNĐ</Card.Text>

                            </Card.Body>
                            <Carousel >
                                <Carousel.Item interval={3000}>
                                    <img variant="top" src={c.imgPost} style={{ height: '300px', width: '1300px' }} />

                                    <Carousel.Caption>
                                        <h3>First slide label</h3>
                                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                                    </Carousel.Caption>
                                </Carousel.Item>
                                <Carousel.Item interval={3000}>
                                    <img variant="top" src={c.imgPost} style={{ height: '300px', width: '1300px' }} />
                                    <Carousel.Caption>
                                        <h3>Second slide label</h3>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                    </Carousel.Caption>
                                </Carousel.Item>
                                <Carousel.Item>
                                    <img variant="top" src={c.imgPost} style={{ height: '300px', width: '1300px' }} />
                                    <Carousel.Caption>
                                        <h3>Third slide label</h3>
                                        <p>
                                            Praesent commodo cursus magna, vel scelerisque nisl consectetur.
                                        </p>
                                    </Carousel.Caption>
                                </Carousel.Item>
                            </Carousel>
                            <Button variant="primary">Xem chi tiết</Button>
                            <Button variant="danger">Đặt hàng</Button>
                        </Card>

                    </Col>)
            }
        </Row>
    </Container>)
}
export default Home;