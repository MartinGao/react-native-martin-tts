using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Martin.Tts.RNMartinTts
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNMartinTtsModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNMartinTtsModule"/>.
        /// </summary>
        internal RNMartinTtsModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNMartinTts";
            }
        }
    }
}
