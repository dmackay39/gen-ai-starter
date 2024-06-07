import React from 'react';
import Card from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';

const SentADisplay = () => {
    return (
    <div>
        <h1>Sentiment Analysis</h1>
        <CardGroup>
        <Card>
            <Card.Body>
                <Card.Title>This AI will tell you the sentiment of a statement you input!</Card.Title>
                <InputGroup className="mb-3">
                    <Form.Control
                        placeholder="Your statement here"
                        aria-label="user Question"
                        aria-describedby="basic-addon2"
                    />
                    <Button variant="outline-secondary" id="button-addon2">
                     Submit
                    </Button>
                </InputGroup>
            </Card.Body>
        </Card>
        <Card>
            <Card.Body>
                <Card.Title>AI Response</Card.Title>
                <Card.Text>
                </Card.Text>
            </Card.Body>
        </Card>
        </CardGroup>
    </div>
    )
};

export default SentADisplay;