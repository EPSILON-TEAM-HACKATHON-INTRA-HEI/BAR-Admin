import React, { useEffect, useState } from "react";
import { createUser, authentificateUser } from './authentification-provider'
import { Auth, getAuth, onAuthStateChanged } from "firebase/auth";
import { useNavigate } from "react-router-dom";
import { auth } from "../../conf/firebase";
import { Paper , TextField , Button} from "@mui/material";
export default function (): React.ReactElement {
    const [mail, setMail]: [string, Function] = useState("");
    const [pwd, setpwd]: [string, Function] = useState("");
    const navigate = useNavigate()

    useEffect(() => {
        const unsubscribe = onAuthStateChanged(auth, (currentUser) => {
            if (currentUser) {
                navigate('/home');
            }
            else {

            }
        });

        return () => unsubscribe();
    }, []);

    function handleclick() {
        authentificateUser(mail, pwd);
    }
    return (
        <>
            <Paper elevation={3} className="paper">
                <h1>test.com</h1>
                <TextField type={"email"} name="email" onInput={(e: any) => { setMail(e.target.value) }} label="email" variant="outlined" className="input"/>
                <TextField type={"password"} name="password" onInput={(e: any) => { setpwd(e.target.value) }} label="password" variant="outlined" className="input"/>
                <div className="btn-field">
                    <Button variant="contained" type={"submit"} onClick={() => { createUser(mail, pwd) }}>Sign up</Button>
                    <Button variant="contained" type={"submit"} onClick={() => { handleclick() }}>Sign in</Button>
                </div>
            </Paper>
        </>
    )
}
