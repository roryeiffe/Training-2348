module.exports = {
  testEnvironment: "jsdom",
  transform: {
    "^.+\\.(ts|tsx|js|jsx)$": "babel-jest",
  },
  setupFilesAfterEnv: ["<rootDir>/src/setupTests.ts"],
};