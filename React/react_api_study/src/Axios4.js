import { useState, useEffect } from "react";
import axios from "axios";
import * as React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";

const Axios4 = () => {
  const [data, setData] = useState(null);
  const getMemberList = () => {
    axios.get("http://localhost:8090/api/member/all").then((res) => {
      setData(res.data);
    });
  };
  useEffect(() => {
    getMemberList();
  }, []);
  return (
    <>
      <h1>회원 목록</h1>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>번호</TableCell>
              <TableCell align="right">이름</TableCell>
              <TableCell align="right">이메일</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {data &&
              data.map((row) => (
                <TableRow
                  key={row.no}
                  sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                >
                  <TableCell component="th" scope="row">
                    {row.no}
                  </TableCell>
                  <TableCell align="right">{row.name}</TableCell>
                  <TableCell align="right">{row.email}</TableCell>
                </TableRow>
              ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};
export default Axios4;
