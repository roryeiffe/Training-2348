## AI - Artificial Intelligence
- A field of computer science that involves the creation of "intelligent" agents/programs/systems that can perform tasks that historically require human intelligence (learning, reasoning, problem-solving)
- Common Uses
  - Google Maps
  - Music Recommendations
  - Enemy Intelligence in Video Games
  - Spam Filters
  - Targeted Ads
- Sub-fields 
  - Machine Learning
  - Deep Learning
  - Natural Language Processing
  - Computer Vision

## ML and DL
### Machine Learning
- Branch of aI that involves the creation of models and algorithms that let computers learn from data
- Learn from large amounts of data, gain the ability to identify patterns and make decisions without being pre-programmed on how to explicitly handle every single situation
- Common Applications
   - Product Recommendations
   - Speech Recognition
   - Fraud Detection in banking app
   - Self-Driving Cars
- Model - an algorithm that is trained to perform some specific task (classify pictures, interpret speech and respond back)
- Supervised ML
  - Models are trained on known data-sets (ex: picture of clothing with labels, pictures of hand-written characters/words with labels representing what they actually say)
  - Can also use labelled test data to evaluate the performance of the model
  - Used for predictions and classification
- Unsupervised ML
  - Trained on data that doesn't have labels
  - Model forms its own patterns and comes to its own conclusions
  - Useful in identifying patterns within large/unlabelled datasets, such as identifying on social media
- Semi-supervised
  - Initially trained on a smaller, labelled data set to get started
  - Then, processes larger, unlabelled datasets
  - Useful when we want to classify but we don't have a large/labelled dataset
- Reinforcement Learning
  - Using trial and error to learn/train
  - Repeatedly performing some actions, receiving feedback, and iteratively changing and acquiring an understanding of the situation
  - ex: learning to play chess
### Deep Learning
- Subset of Machine Learning
- Multilayered neural networks, inspired by the structure of the human brain
- Uses artificial "neurons" to learn from data
- Requires really large amounts of data to train
- Use Cases
  - Image Classification
  - Text Processing
- Multiple layers
  - input layer receives some data
  - hidden layers that transform the data
  - output layer - predictions

## Generative AI
- Type of AI that lets us generative new content (text, images, videos, music, code, etc.)
## How It Works
- Trained on large datasets using deep learning networks
- The model learn many different parameters and patterns which are used to generate the content
- Typically, we send in a human readable prompt as input and receive the generated content as output
### Use Cases
- Text - chatbots, generating essays/papers/paragraphs 
- Image - generating images with specific styles, content, filters
- Speech - synthesizing human-like voice (chat-bots)
- Video - generating a quick video for a presentation

### LLM
- Large Language Models
- Power chatbots like ChatGPT, Google Gemini
### Best Practices 
- Give context (what you're working on, technologies)
- Write detailed instructions, break down complex instructions into manageable steps
  - Can also give sample output so the model "knows" what shape/format the output should be
- Inspect the results carefully, especially if the LLM is performing complex reasoning (follow the logic and see if it makes sense)
- Optionally, have an LLM generate a prompt for you, should be pretty verbose and detailed. Send that prompt in to the LLM to generate your response
- Recognize LLMs aren't magic
  - Verify information
  - When generating code, inspect it carefully and test it out
  - Recognize when a task might be too complex for an LLM 

### Natural Language Processing