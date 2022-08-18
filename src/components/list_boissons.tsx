import React, { MouseEvent, MouseEventHandler } from 'react';
import { Button, Pagination } from "@mui/material";
export default function (props:{toggle:MouseEventHandler<HTMLTableCellElement>,toogleNew:MouseEventHandler<HTMLButtonElement>,toogleToOther:MouseEventHandler<HTMLButtonElement>}): React.ReactElement {
    const {toggle,toogleToOther,toogleNew}=props;
    return (
        <div className="card-body list-div col-11">
            <h1>drinks</h1><button onClick={toogleToOther}>to cocktail</button>
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
                    <Row boisson='haha' prix={12200} categorie="non-alcoliser" update={toggle}/>
                </tbody>
            </table>
            </div>
            <Pagination className='pagination' />
            <button onClick={toogleNew} className="btn-cocktail">new cocktail</button>
            
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