
import React, { useContext, useEffect, useState } from "react";
import { Button, Col, Form, Image, ListGroup, Row } from "react-bootstrap";
import Moment from "react-moment";
import { Link, useParams } from "react-router-dom";
import { MyUserContext } from "../App";
import Apis, { authApi, endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";

const PostDetails = () => {
    const [user,] = useContext(MyUserContext);
    const { idPost } = useParams();
    const [post, setPost] = useState(null);
    const [comments, setComments] = useState(null);
    const [content, setContent] = useState();

    useEffect(() => {
        const loadPost = async () => {
            let { data } = await Apis.get(endpoints['details'](idPost));
            setPost(data);
        }

        const loadComments = async () => {
            let { data } = await Apis.get(endpoints['comments'](idPost));
            setComments(data);
        }

        loadPost();
        loadComments();
    }, []);

    const addComment = () => {
        const process = async () => {
            let { data } = await authApi().post(endpoints['add-comment'], {
                "content": content,
                "idPost": post.idPost, 

            });

            setComments([...comments, data]);
        }

        process();
    }

    if (post === null || comments === null)
        return <MySpinner />;

    let url = `/login?next=/posts/${idPost}`;
    return (
        <React.Fragment>
            <h1 className="text-center text-info mt-2">CHI TIẾT PHÒNG({idPost})</h1>
            <Row>
                <Col md={5} xs={6}>
                    <Image src={post.imgPost} rounded fluid />
                </Col>
                <Col md={5} xs={6}>
                    <h2 className="text-danger">{post.titlePost}</h2>
                    <p>{post.titlePost}</p>
                    <h3>{post.giaTien} VNĐ</h3>
                </Col>
            </Row>
            <hr />


            {user === null ? <p>Vui lòng <Link to={url}>đăng nhập</Link> để bình luận! </p> : <React.Fragment>
                <Form.Control as="textarea" aria-label="With textarea" value={content} onChange={e => setContent(e.target.value)} placeholder="Nội dung bình luận" />
                <Button onClick={addComment} className="mt-2" variant="info">Bình luận</Button>
            </React.Fragment>}
            <hr />
            <ListGroup>
                {
                    comments.map(c => (<ListGroup.Item id={c.idComment}>
                    {c.idUser.username} - {c.content} - <Moment locale="vi" fromNow>{c.createdDate}</Moment>
                </ListGroup.Item>))
                }
            </ListGroup>
        </React.Fragment>
    )

}

export default PostDetails;