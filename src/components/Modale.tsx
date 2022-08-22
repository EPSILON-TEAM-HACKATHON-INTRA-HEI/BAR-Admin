import axios from 'axios';
import React, { MouseEventHandler, useEffect, useState } from 'react';
import '../App.css'
export default function (props: { toggle: MouseEventHandler<HTMLDivElement> , currentDrink:any}): React.ReactElement {
    const { toggle , currentDrink } = props;
    const [boisson, setBoisson] = useState<string>(currentDrink.Name);
    const [prix, setPrix] = useState<string>(currentDrink.UnitPrice);
    const [categorie, setCategorie] = useState<string>(currentDrink.Category)
    function update() {
        function update() {
            axios.patch("https://bar-admin.herokuapp.com/drinks", [
                {
                    "id": currentDrink.id,
                    "Name": boisson,
                    "UnitPrice": prix,
                    "Category": categorie
                }
            ], {
                auth: {
                    username: "admin",
                    password: "admin"
                }
            })
        }
    }
    return (<>
        <div className='hide' onClick={toggle}></div>
        <div className='modale'>
            <div className='modale-head'>update</div>
            <p>boisson</p>
            <input type={"text"} value={boisson} onChange={(e: any) => { setBoisson(e.target.value) }} />
            <p>prix</p>
            <input type={"number"} value={prix} onChange={(e: any) => { setPrix(e.target.value) }} />
            <Categories onchange={setCategorie} value={categorie} />
            <button onClick={update} className="btn-cocktail btn-custom">send</button>
        </div>
    </>
    )
}
export function Modale_new_drinks(props: { toggle: MouseEventHandler<HTMLDivElement> }): React.ReactElement {
    const { toggle } = props;
    const [boisson, setBoisson] = useState<string>("");
    const [prix, setPrix] = useState<string>("");
    const [categorie, setCategorie] = useState<string>("")
    function update() {
        axios.post("https://bar-admin.herokuapp.com/drinks", [
            {
                "id": 0,
                "Name": boisson,
                "UnitPrice": prix,
                "Category": categorie
            }
        ], {
            auth: {
                username: "admin",
                password: "admin"
            }
        })
    }
    return (<>
        <div className='hide' onClick={toggle}></div>
        <div className='modale'>
            <div className='modale-head'>new drinks</div>
            <p>boisson</p>
            <input type={"text"} value={boisson} onChange={(e: any) => { setBoisson(e.target.value) }} />
            <p>prix</p>
            <input type={"number"} value={prix} onChange={(e: any) => { setPrix(e.target.value) }} />
            <Categories onchange={setCategorie} value={categorie} />
            <button onClick={update} className="btn-cocktail btn-custom">send</button>
        </div>
    </>
    )
}
function Categories(props: { onchange: any, value: any }): React.ReactElement {
    const { onchange, value } = props
    const [data, setData] = useState<any>();
    useEffect(() => {
        axios.get("https://bar-admin.herokuapp.com/Categories", {
            auth: {
                username: "admin",
                password: "admin"
            }
        }).then((Data) => {
            setData(Data);
        }).catch((err) => { console.log(err) })
    })
    return (<>
        <p>categories</p>
        <input type={"text"} list="categories" value={value} onChange={(e: any) => { onchange(e.target.value) }} />
        <datalist id="categories">
            {
                data !== undefined && data.map((i:any) => (<option value={i.name} />))}
        </datalist>
    </>
    )
}
export function Modale_newCocktail(props: { toggle: MouseEventHandler<HTMLDivElement>, boissons: any }): React.ReactElement {
    const { toggle, boissons } = props;
    const [data,setData]=useState<any>();
    useEffect(()=>{
        axios.get("https://bar-admin.herokuapp.com/drinks",{
        auth:{
            username:"admin",
            password:"admin"
        }
    }).then((data)=>{setData(data)}).catch((Err)=>{console.log(Err)})

    })
    return (<>
        <div className='hide' onClick={toggle}></div>
        <div className='modale modale-cocktail'>
            <div className='modale-head'>new coktail</div>
            {boissons.map((i: any) => (<div className='row-input'>
                <input type="checkbox" name="test" id={i.id}  onChange={(e:any)=>{console.log(e.target.id)}}/><p>{i.Name}</p>
            </div>
            ))}
            <button className="btn-cocktail btn-custom">send</button>
        </div>
    </>
    )
}
