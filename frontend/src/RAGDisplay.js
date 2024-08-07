import React, { useEffect, useRef, useState } from 'react';
import Card from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import DisplayResponse from './DisplayResponse';

const RAGDisplay = () => {
    const [submitClicked, setSubmitClicked] = useState(0);
    const [userMessage, setUserMessage] = useState('');
    const hasPageBeenRendered = useRef(false);
    const [responseData, setResponseData] = useState(null);
    
    useEffect (() => {
      if (hasPageBeenRendered.current) {
          const getResponse = async () => {
              try {
                  const response = await fetch('http://localhost:8080/rag?message='+userMessage);
                  const data = await response.json();
                  console.log(data);
                  setResponseData(data);
              } catch (error) {
                  console.error('Error fetching data: ', error);
              }
          };
          getResponse();
      }
      hasPageBeenRendered.current = true;
  }, [submitClicked]
  );

    return (
    <div>
    <h1>Retrieval Augmented Generation</h1>
    <CardGroup>
      <Card>
        <Card.Body>
          <Card.Title>This AI answers questions on Einstein's relativity. Ask a question below!</Card.Title>
          <InputGroup className="mb-3">
            <Form.Control
            placeholder="Your question here"
            aria-label="user Question"
            aria-describedby="basic-addon2"
            type='text'
            value={userMessage}
            onChange={(e) => setUserMessage(e.target.value)}
            />
            <Button variant="outline-secondary" id="button-addon2" onClick={(e) => setSubmitClicked(submitClicked+1)}>
                Submit
            </Button>
            </InputGroup>
        </Card.Body>
      </Card>
      <Card>
        <Card.Body>
          <Card.Title>AI Response</Card.Title>
          <Card.Text>
            {DisplayResponse(responseData)}
          </Card.Text>
        </Card.Body>
      </Card>
    </CardGroup>
    </div>
    )
};

export default RAGDisplay;