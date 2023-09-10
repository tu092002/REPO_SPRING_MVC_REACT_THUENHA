import React, { useRef, useState } from "react";
import { Alert, Button, Container, Form } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { useNavigate } from "react-router-dom";
import MySpinner from "../layout/MySpinner";


const Register = () => {

    const avatar = useRef();
    const nav = useNavigate();
    const [loading, setLoading] = useState(false);

    const [err, setErr] = useState()
    const [user, setUser] = useState({
        "hoten": "",
        "username": "",
        "password": "",
        "confirmPass": "",
        "phone": "",
        "address": "",
        "role": ""
    }
    )

    const register = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {


                let form = new FormData();

                for (let field in user) {
                    if (field !== "confirmPass")
                        form.append(field, user[field]);
                }
                form.append("avatar", avatar.current.files[0]);
                setLoading(true)

                let res = await Apis.post(endpoints['register'], form);
                if (res.status === 201)
                    nav("/login");
                else
                    setErr("Hệ thống bị lỗi!");

            }
            catch (ex) {
                console.error(ex);
            }
        }
        if (user.password === user.confirmPass)
            process();
        else
            setErr("Mật khẩu không khớp !!")
    }
    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        setUser(current => {
            return { ...current, [field]: evt.target.value }
        })
    }
    return (
        <Container>
            <h1>ĐĂNG KÍ TÀI KHOẢN</h1>

            {err === null ? "" : <Alert variant="danger">{err}</Alert>}

            <Form method="post" onSubmit={register}>
                <Form.Group className="mb-3">
                    <Form.Label>hoten</Form.Label>
                    <Form.Control type="text" value={user.hoten} onChange={(e) => change(e, "hoten")} placeholder="Họ tên " required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>username</Form.Label>
                    <Form.Control type="text" value={user.username} onChange={(e) => change(e, "username")} placeholder="username " required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Mật khẩu</Form.Label>
                    <Form.Control type="password" value={user.password} onChange={(e) => change(e, "password")} placeholder="Mật khẩu" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Xác nhận mật khẩu</Form.Label>
                    <Form.Control type="password" value={user.confirmPass} onChange={(e) => change(e, "confirmPass")} placeholder="Xác nhận Mật khẩu" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Ảnh đại diện</Form.Label>
                    <Form.Control type="file" ref={avatar} />
                </Form.Group>

                <Form.Group className="mb-3">
                    <Form.Label>address</Form.Label>
                    <Form.Control type="text" value={user.address} onChange={(e) => change(e, "address")} placeholder="address" required />
                </Form.Group><Form.Group className="mb-3">
                    <Form.Label>Phone</Form.Label>
                    <Form.Control type="number" value={user.phone} onChange={(e) => change(e, "phone")} placeholder="phone" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>role</Form.Label>
                    <Form.Control type="text" value={user.role} onChange={(e) => change(e, "role")} placeholder="role" required />
                </Form.Group>

                <Form.Group className="mb-3">
                    {loading === true ? <MySpinner /> : <Button variant="info" type="submit">Đăng ký</Button>}
                </Form.Group>
            </Form>
        </Container>
    )
}

export default Register;