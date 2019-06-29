
# react-native-martin-tts

## Getting started

`$ npm install react-native-martin-tts --save`

### Mostly automatic installation

`$ react-native link react-native-martin-tts`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-martin-tts` and add `RNMartinTts.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNMartinTts.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNMartinTtsPackage;` to the imports at the top of the file
  - Add `new RNMartinTtsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-martin-tts'
  	project(':react-native-martin-tts').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-martin-tts/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-martin-tts')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNMartinTts.sln` in `node_modules/react-native-martin-tts/windows/RNMartinTts.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Martin.Tts.RNMartinTts;` to the usings at the top of the file
  - Add `new RNMartinTtsPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNMartinTts from 'react-native-martin-tts';

// TODO: What to do with the module?
RNMartinTts;
```
  