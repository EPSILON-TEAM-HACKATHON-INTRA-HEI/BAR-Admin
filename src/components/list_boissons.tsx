import React, { MouseEvent, MouseEventHandler, useEffect, useState } from 'react';
import { Button, Pagination } from "@mui/material";
import axios from 'axios';
export default function (props:{toggle:MouseEventHandler<HTMLTableCellElement>,toogleNew:MouseEventHandler<HTMLButtonElement>,toogleToOther:MouseEventHandler<HTMLButtonElement>}): React.ReactElement {
    const {toggle,toogleToOther,toogleNew}=props;
    const [data,setData]=useState<any>();
    useEffect(()=>{
        axios.get("https://bar-admin.herokuapp.com/drinks",{
        auth:{
            username:"test",
            password:"test"
        }
    }).then((data)=>{setData(data)}).catch((Err)=>{console.log(Err)})

    })
    const test=[
        {
          "id": 0,
          "Name": "adfjadsf",
          "UnitPrice": 123,
          "Category": "strasdfas"
        },
        {
            "id": 0,
            "Name": "strasfadsf",
            "UnitPrice": 123,
            "Category": "sasdfasdag"
          },
          {
            "id": 0,
            "Name": "strsadaf",
            "UnitPrice": 32,
            "Category": "stradfasdg"
          }
      ]
    return (
        <div className="card-body list-div col-11">
            <h1>drinks</h1>
            <div className='drinks'>
            <table className="datatables">
                <thead>
                    <tr>
                        <th>boisson</th>
                        <th>prix</th>
                        <th className='categorie'>categorie</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {/* {data !== undefined && data.map((i:any)=>(
                        <Row boisson={i.Name} prix={i.UnitPrice} categorie={i.Category} update={()=>{toggle(i)}}/>
                    ))} */}
                    {
                        test.map((i:any)=>(
                        <Row boisson={i.Name} prix={i.UnitPrice} categorie={i.Category} update={()=>{toggle(i)}}/>
                        ))
                    }
                </tbody>
            </table>
            </div>
            <Pagination className='pagination' />
            <button onClick={toogleNew} className="btn-cocktail">new cocktail</button>
            <button onClick={toogleToOther} className="btn-cocktail to_drinks">{"to cocktail -->"} </button>
            
        </div>
    )
}
interface RowPropsType{
    boisson:string;
    prix:number;
    categorie:string;
    update:MouseEventHandler<HTMLTableCellElement>;
}
function Row(props:RowPropsType): React.ReactElement {
    const {boisson,prix,categorie,update}=props;
    return (
        <tr>
            <td>{boisson}</td>
            <td>{prix}</td>
            <td>{categorie}</td>
            <td onClick={update}>+</td>
        </tr>
    )
}